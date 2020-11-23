package com.Shopee;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.Query;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class CartService {
	public static final String COL_NAME = "carts";

	public String saveCart(Cart cart) throws InterruptedException, ExecutionException {
		cart.setDatenow();
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME)
				.document(Integer.toString(cart.getId())).set(cart);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public Cart getCart(int id) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(Integer.toString(id));
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		DocumentSnapshot document = future.get();

		Cart cart = null;

		if (document.exists()) {
			cart = document.toObject(Cart.class);
			return cart;
		} else {
			return null;
		}
	}

	public List<Cart> getCartall(String uid) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		// asynchronously retrieve multiple documents
		ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).whereEqualTo("user_id", uid).get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();

		List<Cart> cartlist = new ArrayList<>();
		for (DocumentSnapshot document : documents) {
			// System.out.println(document.getId() + " => " +
			// document.toObject(Cart.class));
			cartlist.add(document.toObject(Cart.class));
		}

		return cartlist;

	}

	public String updateCart(Cart cart) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME)
				.document(Integer.toString(cart.getId())).set(cart);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String PatchCart(int id, String fieldPath, Object value) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(Integer.toString(id))
				.update(fieldPath, value);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deleteCart(int id) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(Integer.toString(id)).delete();
		return "Document with Cart ID " + id + " has been deleted";
	}

}
