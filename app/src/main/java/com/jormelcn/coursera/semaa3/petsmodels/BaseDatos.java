package com.jormelcn.coursera.semaa3.petsmodels;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jormelcn on 12/06/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, "pets_db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTablaContactos = "CREATE TABLE contactos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "foto INTEGER, " +
                "rating INTEGER) ";
        db.execSQL(queryTablaContactos);

        String queryTablaLikes = "CREATE TABLE likes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "foto INTEGER, " +
                "rating INTEGER) ";
        db.execSQL(queryTablaLikes);
    }

    public ArrayList<Pet> getPets(){

        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM contactos";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            pets.add(new Pet(registros.getInt(2), registros.getString(1), registros.getInt(2)));
        }
        db.close();
        return  pets;
    }

    public ArrayList<Pet> getPetsLikes(){

        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM contactos ORDER BY id DESC LIMIT 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            pets.add(new Pet(registros.getInt(2), registros.getString(1), registros.getInt(3)));
        }
        db.close();
        return  pets;
    }

    public Pet getPet(int id){
        String query = "SELECT * FROM contactos WHERE id = " + String.valueOf(id);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registro = db.rawQuery(query, null);
        registro.moveToNext();
        //db.close();
        return  new Pet(registro.getInt(2), registro.getString(1), registro.getInt(3));
    }

    public void addLike(int id){
        Pet pet = getPet(id);
        String query1 = "UPDATE contactos SET rating=" + String.valueOf(pet.getRating() + 1) + " WHERE id="+ String.valueOf(id);
        String query2 = "INSERT INTO likes(nombre, foto, rating) VALUES " +
                "(\"" + pet.getName() + "\", " +
                String.valueOf(pet.getPicture()) + ", " +
                String.valueOf(pet.getRating() + 1) + " )";
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(query1, null);
        db.rawQuery(query2, null);
        //db.execSQL(query1);
        //db.execSQL(query2);
        db.close();
    }

    public void addPets(ArrayList<Pet> pets){
        SQLiteDatabase db = this.getWritableDatabase();

        for(int i = 0; i < pets.size(); i++){
            String query = "INSERT INTO contactos (nombre, foto, rating) VALUES " +
            "(\"" + pets.get(i).getName() + "\", " + String.valueOf(pets.get(i).getPicture()) + ", " + String.valueOf(pets.get(i).getRating()) + ")";
            db.execSQL(query);
        }
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
