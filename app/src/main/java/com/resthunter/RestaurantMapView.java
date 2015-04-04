package com.resthunter;

import android.util.Log;

import com.resthunter.rest.RestClient;
import com.resthunter.rest.model.MenuEntry;
import com.resthunter.rest.model.Place;
import com.resthunter.rest.service.RestHunterApiService;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by cleac on 04.04.15.
 */
public class RestaurantMapView {

    public static final String dummy_icon = "http://apptractor.ru/wp-content/uploads/2014/06/github-icon.png";
    public static final String dummy_background = "http://fc08.deviantart.net/fs20/i/2007/269/5/9/Green_Cloth_by_teqox_stock.jpg";
    public static StringBuilder document;

    public RestaurantMapView() {
        document = new StringBuilder()
                .append(declaration_start);
        RestHunterApiService restApi = new RestClient().getApiService();

        ArrayList<Place> array_list = restApi.getPlaceList();
        for(int i = 0; i<array_list.size();i++) {
            document.append(pattern_decl_start)
                    .append(array_list.get(i).getUser())
                    .append(pattern_decl_middle)
                    .append(dummy_icon)
                    .append(pattern_decl_end);
        }
        document.append(declaration_end);

        document.append(image_start)
                .append(dummy_background)
                .append(image_end);

        for(int i=0;i<array_list.size();i++) {
            document.append(circle_start)
                    .append(array_list.get(i).getX())
                    .append(circle_first)
                    .append(array_list.get(i).getY())
                    .append(circle_second)
                    .append("user")
                    .append(array_list.get(i).getUser())
                    .append(circle_end);
        }

        document.append(svg_end)
                .append(body_end);
    }

    public static final String declaration_start = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js\"></script>\n" +
            "</head> \n" +
            "<body>\n" +
            "<h1>My first SVG</h1>\n" +
            "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
            "<svg width=\"700\" height=\"700\" version=\"1.1\"\n" +
            "     xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink= \"http://www.w3.org/1999/xlink\">\n" +
            "<defs>";
    public static final String pattern_decl_start = "<pattern id=\"user";

    public static final String pattern_decl_middle = "\" name=\"\" patternUnits=\"userSpaceOnUse\" height=\"50\" width=\"50\">\n" +
            "  <image x=\"10\" y=\"0\" height=\"40\" width=\"40\" xlink:href=\"";
    public static final String pattern_decl_end = "\"></image>\n" +
            "</pattern>";
    public static final String declaration_end = "</defs>";
    public static final String image_start = "<image xlink:href=\"";
    public static final String image_end = "\" x=\"0\" y=\"0\" height=\"100%\" width=\"100%\"/>";
    public static final int user_count = 3;
    public static final String circle_start = "<circle id='avatar' cx=\"";
    public static final String circle_first = "\" cy=\"";
    public static final String circle_second = "\" r=\"20\" fill=\"url(#";
    public static final String circle_end = ")\"/>";
    public static final String svg_end = "</svg>";
    public static final String body_end = "</body>";

    public void show(/*int restaurant_id*/) {
/*        document = new StringBuilder();

        document.append(declaration_start);
        //Declared header
        for (int i = 0; i < user_count; i++) {
            document.append(pattern_decl_start);
            document.append(i);
            document.append(pattern_decl_middle);
            document.append(i);
            document.append(pattern_decl_end);
            //Declared user number i
        }
        document.append(declaration_end);
        //Finished declaration

        document.append(image_start);
        document.append("Pabracadabra");
        document.append(image_end);
        //Implemented image on background

        for(int i = 0; i<user_count;i++) {
            document.append(circle_start);
            document.append(2*i);
            document.append(circle_first);
            document.append(3*i);
            document.append(circle_second);
            document.append("user").append(i);
            document.append(circle_end);
        }
        //Ended implementation of user icons

        document.append(svg_end)
                .append(body_end);

        Log.v("TEST",document.toString());*/
        Log.v("Test",document.toString());

    }
}
