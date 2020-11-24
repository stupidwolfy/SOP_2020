let orderdata;

var url = new URL(window.location.href);
var idd = url.searchParams.get("id");

let orderId = idd;
//let groupedproduct;

orderId ? getOrder(orderId) : null;

function promoCheck(promocode) {
    let resultField = $("#promoResult");
    //alert(promocode);
    resultField.text("Checking...");
    axios.get('https://mhee-promotion.herokuapp.com/promotions/' + promocode)
        .then(function(response) {
            resultField.text(response.data.description);
            if (response.data.description == "Valid code") {
                addPromo(promocode);
            }
        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            //console.log(orderdata);
            //cardGenerator(shopName, productlist);
        });
}

function addPromo(promocode) {
    axios.patch('/order/promotion/' + orderId + "/" + promocode)
        .then(function(response) {

        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            // always executed
        });
}

function getOrder(orderid) {
    axios.get('/order/' + orderid)
        .then(function(response) {
            // handle success
            //console.log(response.data);
            $("#btnsearch1").attr("href", "https://shopee2.herokuapp.com/detailorder/" + orderId);
            orderdata = response.data;
            orderdata.product.forEach(function(product, index, array) {
                if (index === orderdata.product.length - 1) {
                    getProduct(product.id, index, true);
                } else {
                    getProduct(product.id, index);
                }
            });
        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            //console.log(orderdata);
            //cardGenerator(shopName, productlist);
        });
}

function getProduct(ptoductid, index, islast = false) {
    axios.get('/dummy/product/' + ptoductid)
        .then(function(response) {
            // handle success
            //console.log(response.data);
            orderdata.product[index] = {...orderdata.product[index], ...response.data };
            if (islast) {
                console.log("last product loaded");
                //cardGenerator("1155", orderdata.product);
                //console.log(orderdata.product);
                shopSorter(orderdata);
                shopRender(orderdata);
            }
        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            // always executed
        });
}

function getShop(shopid, order, islast = false) {
    axios.get('/dummy/shop/' + shopid)
        .then(function(response) {
            // handle success
            //console.log(response.data);
            order.shop[shopid] = { product: {...order.shop[shopid] }, ...response.data };
            cardGenerator(order.shop[shopid]);
        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            // always executed
        });
}

function shopSorter(order) {
    orderdata.shop = _.groupBy(order.product, 'shopId');
}

function removeProduct(target, productId) {
    target.parentNode.parentNode.parentNode.removeChild(target.parentNode.parentNode);
    axios.delete('/order/product/' + orderId + '/' + productId)
        .then(function(response) {})
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            // always executed
        });
}

function editProduct(event, productId, price) {
    //console.log(event);
    if (event.key === 'Enter') {
        event.target.parentNode.nextElementSibling.innerText = "Loading..";
        //alert(orderId + ", " + productId + ": " + event.target.value);
        axios.patch('/order/product/' + orderId, {
                "id": productId,
                "amount": event.target.value,
                "total": price * event.target.value
            })
            .then(function(response) {
                //console.log(event.target.parentNode.nextElementSibling.innerText);
                event.target.parentNode.nextElementSibling.innerText = price * event.target.value;
            })
            .catch(function(error) {
                // handle error
                console.log(error);
            })
            .then(function() {
                // always executed
            });
    }
}

function shopRender(order) {
    for (const shop in order.shop) {
        getShop(shop + "", order);
        //cardGenerator(shop, order.shop[shop]);
    }
}

function cardGenerator(shoppool) {
    let shopName = shoppool.name;
    let productlist = shoppool.product;

    let box = document.querySelector("#bigblock");
    let promoblock = document.querySelector("#promoblock");

    let shopdiv = document.createElement("div");
    shopdiv.setAttribute("id", "block1");
    shopdiv.setAttribute("class", "card");

    let headerdiv = document.createElement("div");
    headerdiv.setAttribute("class", "card-header");
    headerdiv.innerText = shopName;

    let bodydiv = document.createElement("div");
    bodydiv.setAttribute("class", "card-body");

    let blockquote = document.createElement("blockquote");
    blockquote.setAttribute("class", "blockquote mb-0");

    let table = document.createElement("table");
    table.setAttribute("class", "table table-striped center");
    table.setAttribute("id", "table1");

    let thead = document.createElement("thead");

    let trhead = document.createElement("tr");
    let thheadimg = document.createElement("th");
    thheadimg.setAttribute("scope", "col");
    thheadimg.innerText = "รูปภาพ";

    let thheadname = document.createElement("th");
    thheadname.setAttribute("scope", "col");
    thheadname.innerText = "สินค้า";

    let thheadprice = document.createElement("th");
    thheadprice.setAttribute("scope", "col");
    thheadprice.innerText = "ราคาต่อชิ้น";

    let thheadamount = document.createElement("th");
    thheadamount.setAttribute("scope", "col");
    thheadamount.innerText = "จำนวน";

    let thheadtotal = document.createElement("th");
    thheadtotal.setAttribute("scope", "col");
    thheadtotal.innerText = "ราคารวม";

    let thheadaction = document.createElement("th");
    thheadaction.setAttribute("scope", "col");
    thheadaction.innerText = "แอคชั่น";

    let tbody = document.createElement("tbody");

    for (product in shoppool.product) {
        //console.log(productlist[product]);
        let trbody = document.createElement("tr");

        let thbodyimg = document.createElement("th");
        thheadaction.setAttribute("scope", "row");
        let img = document.createElement("img");
        img.classList.add("img-thumbnail", "img-fluid", "w-25");
        img.src = productlist[product].imageUrl;
        thbodyimg.append(img);

        let tdbodyname = document.createElement("td");
        tdbodyname.innerText = productlist[product].name;
        let tdbodyprice = document.createElement("td");
        tdbodyprice.innerText = productlist[product].price;
        let tdbodyamount = document.createElement("td");


        let tdbodyamountinput = document.createElement("input");
        tdbodyamountinput.setAttribute("class", "form-control col-md-5 center");
        tdbodyamountinput.setAttribute("type", "text");
        tdbodyamountinput.setAttribute("onkeypress", "editProduct(event, " + productlist[product].id + "," + productlist[product].price + ");");
        //tdbodyamountinput.addEventListener("keypress", function(e) { editProduct(e, productlist[product].id, productlist[product].price); });
        tdbodyamountinput.value = productlist[product].amount;

        tdbodyamount.append(tdbodyamountinput);

        let tdbodytotal = document.createElement("td");
        //tdbodytotal.innerText = productlist[product].total;
        tdbodytotal.innerText = productlist[product].price * productlist[product].amount;
        let tdbodyaction = document.createElement("td");
        let deletebutton = document.createElement("button");
        deletebutton.setAttribute("onclick", "removeProduct(this, " + productlist[product].id + ");");
        deletebutton.setAttribute("type", "button");
        deletebutton.setAttribute("class", "btn btn-danger");
        deletebutton.innerText = "ลบสินค้า";
        tdbodyaction.append(deletebutton);


        trbody.append(thbodyimg);
        trbody.append(tdbodyname);
        trbody.append(tdbodyprice);
        trbody.append(tdbodyamount);
        trbody.append(tdbodytotal);
        trbody.append(tdbodyaction);

        tbody.append(trbody);
    }


    trhead.append(thheadimg);
    trhead.append(thheadname);
    trhead.append(thheadprice);
    trhead.append(thheadamount);
    trhead.append(thheadtotal);
    trhead.append(thheadaction);


    thead.append(trhead);
    table.append(thead);
    table.append(tbody);
    blockquote.append(table);
    bodydiv.append(blockquote);
    shopdiv.append(headerdiv);
    shopdiv.append(bodydiv);
    box.insertBefore(shopdiv, promoblock);
}


//updateAmount(5);
//cardGenerator("shoptesttttt");