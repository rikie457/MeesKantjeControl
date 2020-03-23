package mk.meeskantje.meeskantjecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mk.meeskantje.meeskantjecontrol.data.DataProvider;
import mk.meeskantje.meeskantjecontrol.data.response.ArrayListResponse;
import mk.meeskantje.meeskantjecontrol.data.response.CoordinateResponse;
import mk.meeskantje.meeskantjecontrol.data.response.CountryResponse;
import mk.meeskantje.meeskantjecontrol.data.response.DroneResponse;
import mk.meeskantje.meeskantjecontrol.data.response.SensorLogResponse;
import mk.meeskantje.meeskantjecontrol.data.response.SensorResponse;
import mk.meeskantje.meeskantjecontrol.model.Coordinate;
import mk.meeskantje.meeskantjecontrol.model.Country;
import mk.meeskantje.meeskantjecontrol.model.Drone;
import mk.meeskantje.meeskantjecontrol.model.Sensor;
import mk.meeskantje.meeskantjecontrol.model.SensorLog;

public class MainActivity extends AppCompatActivity {

    private DataProvider dataProvider;
    private List<Coordinate> listCoordinate;
    private List<Country> listCountry;
    private List<Drone> listDrone;
    private List<Sensor> listSensor;
    private List<SensorLog> listSensorLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataProvider = new DataProvider(this);

        listCoordinate = new ArrayList<>();
        listCountry = new ArrayList<>();
        listDrone = new ArrayList<>();
        listSensor = new ArrayList<>();
        listSensorLog = new ArrayList<>();


        HashMap<String, String> parametersCountry = new HashMap<String, String>();
        parametersCountry.put("id", "1");
        dataProvider.request(DataProvider.GET_COUNTRY, parametersCountry, new CountryResponse() {
            @Override
            public void response(Country data) {
                System.out.println("GET_COUNTRY " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        dataProvider.request(DataProvider.GET_COUNTRIES, null, new ArrayListResponse() {
            @Override
            public void response(ArrayList<?> data) {
                System.out.println("GET_COUNTRIES " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        HashMap<String, String> parametersCoordinates = new HashMap<String, String>();
        parametersCoordinates.put("id", "1");
        dataProvider.request(DataProvider.GET_COORDINATE, parametersCoordinates, new CoordinateResponse() {
            @Override
            public void response(Coordinate data) {
                System.out.println("GET_COORDINATE " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        dataProvider.request(DataProvider.GET_COORDINATES, null, new ArrayListResponse() {
            @Override
            public void response(ArrayList<?> data) {
                System.out.println("GET_COORDINATES " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        HashMap<String, String> parametersDrones = new HashMap<String, String>();
        parametersDrones.put("id", "1");
        dataProvider.request(DataProvider.GET_DRONE, parametersDrones, new DroneResponse() {
            @Override
            public void response(Drone data) {
                System.out.println("GET_DRONE " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        dataProvider.request(DataProvider.GET_DRONES, null, new ArrayListResponse() {
            @Override
            public void response(ArrayList<?> data) {
                System.out.println("GET_DRONES " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        HashMap<String, String> parametersSensor = new HashMap<String, String>();
        parametersSensor.put("id", "1");
        dataProvider.request(DataProvider.GET_SENSOR, parametersSensor, new SensorResponse() {
            @Override
            public void response(Sensor data) {
                System.out.println("GET_SENSOR " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        dataProvider.request(DataProvider.GET_SENSORS, null, new ArrayListResponse() {
            @Override
            public void response(ArrayList<?> data) {
                System.out.println("GET_SENSORS " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        HashMap<String, String> parameterssensorLogs = new HashMap<String, String>();
        parameterssensorLogs.put("id", "1");
        dataProvider.request(DataProvider.GET_SENSORLOG, parameterssensorLogs, new SensorLogResponse() {
            @Override
            public void response(SensorLog data) {
                System.out.println("GET_SENSORLOG " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });

        dataProvider.request(DataProvider.GET_SENSORLOGS, null, new ArrayListResponse() {
            @Override
            public void response(ArrayList<?> data) {
                System.out.println("GET_SENSORLOGS " + data);
            }

            @Override
            public void error(VolleyError error) {
                System.out.println(error);
            }
        });
    }
}
