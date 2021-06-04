package testresources;

import pojoClass.AddPlaceApi;
import pojoClass.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlaceApi addPlacePayload(String name,String language,String place){
        AddPlaceApi addPlaceApi = new AddPlaceApi();
        addPlaceApi.setAccuracy(20);
        addPlaceApi.setName(name);
        addPlaceApi.setPhoneNumber("+91 890228291");
        addPlaceApi.setAddress(place);
        addPlaceApi.setWebsite("http://google.com");
        List<String> myList = new ArrayList<>();
        myList.add("shoe zone");
        myList.add("shop");
        addPlaceApi.setTypes(myList);
        Location lo = new Location();
        lo.setLat(-38.383494);
        lo.setLng(33.427362);
        addPlaceApi.setLocation(lo);

        addPlaceApi.setLanguage(language);
        return addPlaceApi;

    }
}
