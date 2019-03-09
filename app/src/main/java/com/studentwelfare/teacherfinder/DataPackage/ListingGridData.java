package com.studentwelfare.teacherfinder.DataPackage;

public class ListingGridData {
    String _price, _title, _image;

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    String ad_id;
    public ListingGridData(String id, String price, String title, String image){
        this.set_image(image);
        this.setAd_id(id);
        this.set_price(price);
        this.set_title(title);
    }

    public String get_price() {
        return _price;
    }

    public void set_price(String _price) {
        this._price = _price;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_image() {
        return _image;
    }

    public void set_image(String _image) {
        this._image = _image;
    }

}
