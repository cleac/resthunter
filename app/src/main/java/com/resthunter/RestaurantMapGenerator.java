package com.resthunter;

import com.resthunter.rest.RestClient;
import com.resthunter.rest.model.Place;
import com.resthunter.rest.model.Restaurant;

import java.util.ArrayList;

/**
 * Created by cleac on 04.04.15.
 */
public class RestaurantMapGenerator {

    public RestaurantMapGenerator() {
    }

    public static String buildDocument(Restaurant current_restaurant) {
        StringBuilder document = new StringBuilder()
                .append(declaration_start)
                .append(img_start)
                .append(current_restaurant.getInterior())
                .append(img_end);

        ArrayList<Place> current_place = new RestClient().getApiService().getPlaceList();
        for(int i = 0; i < current_place.size();i++) {
            document.append(rect_class_start)
                    .append(current_place.get(i).getX())
                    .append(rect_class_middle)
                    .append(current_place.get(i).getY())
                    .append(rect_class_end);
            Integer circle_x = current_place.get(i).getX() + (current_place.get(i).getWidth() / 2),
                    circle_y = current_place.get(i).getY() + (current_place.get(i).getHeight() / 2);
            if(current_place.get(i).getIsTaken()) {
                //<circle class='avatar' cx="90" cy="210" r="15" data-table="5"style="fill:rgba(240,255,10,1.0)"  />
                document.append(circle_class_start)
                        .append(circle_x)
                        .append(circle_class_middle)
                        .append(circle_y)
                        .append(circle_class_end_free);
            } else {
                //<circle class='avatar' cx="90" cy="210" r="15" data-table="5"style="fill:rgba(190,190,190,0.5)"  />
                document.append(circle_class_start)
                        .append(circle_x)
                        .append(circle_class_middle)
                        .append(circle_y)
                        .append(circle_class_end_unfree);
            }
            //<text x="86" y="213" style="font-weight: bold;">6</text>
            document.append(text_view_start)
                    .append(circle_x - move_by_x)
                    .append(text_view_middle)
                    .append(circle_y + move_by_y)
                    .append(text_view_second_middle)
                    .append(current_place.get(i).getPlaces())
                    .append(text_view_end);
        }
        document.append(declaration_end)
                .append(script)
                .append(close_body);

        return document.toString();
    }




    //We are ashamed of this code.
    //You don't want to look further ;-)

    private static final String declaration_start = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js\"></script>\n" +
            "</head> \n" +
            "<body>\n" +
            "<h1>My first SVG</h1>\n" +
            "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
            "<svg width=\"625\" height=\"422\" version=\"1.1\"\n" +
            "     xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink= \"http://www.w3.org/1999/xlink\">\n";
    public static final String img_start = "<image xlink:href=\"";
    public static final String img_end = "\" x=\"0\" y=\"0\" height=\"100%\" width=\"100%\"/>";
    public static final String rect_class_start = "<rect class='available' fill-opacity=\"fill-opacity\" data-table=\"2\" x=\"";
    public static final String rect_class_end = "\" width=\"94\" height=\"45\" rx=\"20\" ry=\"20\" style=\"fill:rgba(128,255,0,0.5);stroke-width:1;stroke:rgba(0,0,0,1.0)\" />";
    public static final String rect_class_middle = "\" y=\"";
    public static final String circle_class_start = "<circle class='avatar' cx=\"";
    public static final String circle_class_middle = "\" cy=\"";
    public static final String circle_class_end_free = "\" r=\"15\" data-table=\"5\"style=\"fill:rgba(240,255,10,1.0)\"  />";
    public static final String circle_class_end_unfree = "\" r=\"15\" data-table=\"5\"style=\"fill:rgba(190,190,190,0.5)\"  />";
    public static final String text_view_start = "<text x=\"";
    public static final String text_view_middle = "\" y=\"";
    public static final int move_by_x = 4;
    public static final int move_by_y = 4;
    public static final String text_view_second_middle = "\" style=\"font-weight: bold;\">";
    public static final String text_view_end = "</text>";
    public static final String declaration_end = "</svg>";
    public static final String script = "<script>\n" +
            "$('.available').click( function(){\n" +
            "  var table_id = this.getAttribute('data-table')\n" +
            "  Android.bookTable(table_id)\n" +
            "});\n" +
            "</script>";
    public static final String close_body = "</body>";
}
