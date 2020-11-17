let orderdata;

function getOrder(orderid) {
    axios.get('/order/' + orderid)
        .then(function(response) {
            // handle success
            //console.log(response.data);
            orderdata = response.data;
            orderdata.product.forEach(function(product, index, array) {
                getProduct(product.id, index);
            });
        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            console.log(orderdata);
            //cardGenerator(shopName, productlist);
        });
}

function getProduct(ptoductid, index) {
    axios.get('/dummy/product/' + ptoductid)
        .then(function(response) {
            // handle success
            //console.log(response.data);
            orderdata.product[index] = {...orderdata.product[index], ...response.data };
        })
        .catch(function(error) {
            // handle error
            console.log(error);
        })
        .then(function() {
            // always executed
        });
}

getOrder(5);

function removeProduct(target) {
    target.parentNode.parentNode.parentNode.removeChild(target.parentNode.parentNode);
}

//<div id="block1" class="card">
//        <div class="card-header">
//            ร้าน test1
//        </div>
//        <div class="card-body">
//            <blockquote class="blockquote mb-0">
//                <table class="table" id="table1">
//                    <thead>
//                        <form>
//                            <tr>
//                                <th scope="col"><input type="checkbox"></th>
//                                <th scope="col">รูปภาพ</th>
//                                <th scope="col">สินค้า</th>
//                                <th scope="col">ราคาต่อชิ้น</th>
//                                <th scope="col">จำนวน</th>
//                                <th scope="col">ราคารวม</th>
//                                <th scope="col">แอคชั่น</th>
//                            </tr>
//                    </thead>
//                    <tbody>
//                        <tr>
//                            <th scope="row"><input type="checkbox"></th>
//                            <td>Mark</td>
//                            <td>(ต้องสั่ง3ใบเท่านั้นครับ) กล่องรองเท้ารักษ์โลกอเนกประสงค์ สีน้ำตาลคละสี</td>
//                            <td>฿39</td>
//                            <td><input class="form-control col-md-4" type="text" placeholder="จำนวน"></td>
//                            <td>฿39</td>
//                            <td>
//                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
//                                    <path
//                                        d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
//                                    <path fill-rule="evenodd"
//                                        d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
//                                </svg> ลบสินค้า
//                            </td>
//                        </tr>
//                        </form>
//                    </tbody>
//                </table>
//            </blockquote>
//        </div>
//    </div>

function cardGenerator(shopName, productlist) {
    let box = document.querySelector("#bigblock");

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

    productlist.forEach(product => {
        let trbody = document.createElement("tr");

        let thbodyimg = document.createElement("th");
        thheadaction.setAttribute("scope", "row");
        let img = document.createElement("img");
        img.src = product.imageUrl;
        thbodyimg.append(img);

        let tdbodyname = document.createElement("td");
        tdbodyname.innerText = product.name;
        let tdbodyprice = document.createElement("td");
        tdbodyprice.innerText = product.price;
        let tdbodyamount = document.createElement("td");
        let tdbodyamountinput = document.createElement("input");
        tdbodyamountinput.setAttribute("class", "form-control col-md-5 center");
        tdbodyamountinput.setAttribute("type", "text");
        tdbodyamountinput.value = product.amount;
        tdbodyamount.append(tdbodyamountinput);

        let tdbodytotal = document.createElement("td");
        tdbodytotal.innerText = product.total;
        let tdbodyaction = document.createElement("td");
        let deletebutton = document.createElement("button");
        deletebutton.setAttribute("onclick", "removeProduct(this);");
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
    });


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
    box.insertBefore(shopdiv, box.lastElementChild);
}

//updateAmount(5);
//cardGenerator("shoptesttttt");