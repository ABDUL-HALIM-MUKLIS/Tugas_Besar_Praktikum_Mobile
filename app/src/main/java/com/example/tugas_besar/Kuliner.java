package com.example.tugas_besar;

public class Kuliner {
    private String _id, _nama, _asal, _deskripsi;
    public Kuliner (String id, String nama, String asal, String deskripsi) {
        this._id = id;
        this._nama = nama;
        this._asal = asal;
        this._deskripsi = deskripsi;
    }
    public Kuliner() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_asal() {
        return _asal;
    }
    public void set_asal(String _asal) {
        this._asal = _asal;
    }
    public String get_deskripsi() {
        return _deskripsi;
    }
    public void set_deskripsi(String _deskripsi) {
        this._deskripsi = _deskripsi;
    }
}

