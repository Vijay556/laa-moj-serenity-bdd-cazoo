package cazoo.helpers;

import cazoo.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFileReadWriter {
    public static final String SRC_TEST_RESOURCES_FILES = "src/test/resources/files/";

    public String read(String file_name) {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(SRC_TEST_RESOURCES_FILES + file_name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<Car> getCarDetails(String file_name) {
        String carDara = read(SRC_TEST_RESOURCES_FILES + file_name);
        String[] outputLines = carDara.split("\r\n*");
        List<Car> carList = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.stream(outputLines).toList());
        for (String s : list) {
            if (!s.isEmpty() && !s.equals("REGISTRATION,MAKE,MODEL")) {
                Car c = new Car();
                String[] carDetails = s.split(",");
                c.setReg(carDetails[0]);
                c.setMake(carDetails[1]);
                c.setModel(carDetails[2]);
                carList.add(c);
            }
        }
        return carList;
    }
}
