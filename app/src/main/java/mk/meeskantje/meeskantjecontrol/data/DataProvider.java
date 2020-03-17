package mk.meeskantje.meeskantjecontrol.data;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

/*
All repsonses
*/
import mk.meeskantje.meeskantjecontrol.data.response.ArrayListResponse;
import mk.meeskantje.meeskantjecontrol.data.response.JsonArrayResponse;
import mk.meeskantje.meeskantjecontrol.data.response.JsonObjectResponse;
import mk.meeskantje.meeskantjecontrol.data.response.ProviderResponse;
/*
All model
import mk.meeskantje.meeskantjecontrol.model.Group;
*/

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;



//TODO Fix Object or Array Nightmare
public class DataProvider {

    private Context ctx;

    //Api URL here
    //TODO add right api
    private final static String API = "https://www.tychoengberink.nl/api/02/api";

    //Actions
    //TODO add right actions
    public static final String GET_USER = "GET_USER";

    public DataProvider(Context ctx){
        this.ctx = ctx;
        NukeSSLCerts.nuke();
    }

    /**
     * This method makes a request to the webserver.
     * @param action action to take.
     * @param id (Optional) enter the id to find.
     * @param parameters (Optional) Parameters to be send with the request.
     * @param providerResponse The response of the request, should be a subclass of the ProviderResponse interface depending on the action.
     */
    public void request(final String action, final String id, final HashMap<String, String> parameters, final ProviderResponse providerResponse){
        JsonObjectRequest jsonObjectRequest = null;
        String URL = "";

        boolean objectRequest = false;

        switch(action){
            case GET_USER:
                URL = API + "/users/" + id;
                objectRequest = true;
                break;
        }
        JSONObject jsonObject = null;
        if(parameters != null){
            jsonObject = new JSONObject(parameters);
        }
        if(objectRequest){
            objectRequest(action, URL, jsonObject, providerResponse);
        }else{
            arrayRequest(action, URL, jsonObject, providerResponse);
        }
    }

    private void objectRequest(final String action, String URL, final JSONObject parameters, final ProviderResponse providerResponse){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        switch(action){
                            case GET_USER:
//                                    UserResponse userResponse = (UserResponse)providerResponse;
//                                    User user = new User(response.getInt("id"), response.getInt("group_id"), response.getString("username"), response.getString("email"), response.getInt("admin"));
//                                    userResponse.response(user);
                                break;
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        providerResponse.error(error);
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                //TODO change code
               // params.put("secretcode", "24091999");
                params.put("Content-Type", "application/json");
                return params;
            }
            @Override
            public byte[] getBody(){
                String requestBody = parameters.toString();
                try {
                    return requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        NetworkSingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }

    private void arrayRequest(final String action, String URL, final JSONObject parameters, final ProviderResponse providerResponse){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(final JSONArray response) {
                        final ArrayListResponse arrayListResponse = (ArrayListResponse)providerResponse;
                        switch (action) {
//                                case GET_USERS:
//                                    ArrayList<User> users = new ArrayList<>();
//                                    for (int i = 0; i < response.length(); i++) {
//                                        users.add(new User(response.getJSONObject(i).getInt("id"), response.getJSONObject(i).getInt("group_id"), response.getJSONObject(i).getString("username"), response.getJSONObject(i).getString("email"), response.getJSONObject(i).getInt("admin")));
//                                    }
//                                    arrayListResponse.response(users);
//                                    break;

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        providerResponse.error(error);
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                //TODO change code
                params.put("secretcode", "24091999");
                params.put("Content-Type", "application/json");
                return params;
            }
            @Override
            public byte[] getBody(){
                String requestBody = parameters.toString();
                try {
                    return requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        NetworkSingleton.getInstance(ctx).addToRequestQueue(jsonArrayRequest);
    }

    public void customObjectRequest(int method, String URL, final JSONObject parameters, final JsonObjectResponse jsonObjectResponse){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (method, API + URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonObjectResponse.response(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        jsonObjectResponse.error(error);
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                //TODO change code
                params.put("Content-Type", "application/json");
                params.put("secretcode", "24091999");
                return params;
            }
            @Override
            public byte[] getBody(){
                String requestBody = parameters.toString();
                try {
                    return requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        NetworkSingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }

    public void customArrayRequest(int method, String URL, final JSONObject parameters, final JsonArrayResponse jsonArrayResponse){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (method, API + URL, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jsonArrayResponse.response(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        jsonArrayResponse.error(error);
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                //TODO change code
                params.put("secretcode", "24091999");
                params.put("Content-Type", "application/json");
                return params;
            }
            @Override
            public byte[] getBody(){
                String requestBody = parameters.toString();
                try {
                    return requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };
        NetworkSingleton.getInstance(ctx).addToRequestQueue(jsonArrayRequest);
    }
}