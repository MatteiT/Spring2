package com.example.demo2;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class doctorsControllers {

    @GetMapping("/doctor/{incarnationNumber}")
    public RequestEntity<?> getDoctorName(@PathVariable int incarnationNumber) {
        switch (incarnationNumber) {
            case 9 : new Doctor(9, "Christopher Eccleston");
            case 10 : new Doctor(10, "David Tennant");
            case 11: new Doctor(11, "Matt Smith");
            case 12 : new Doctor(12, "Peter Capaldi");
            case 13 : new Doctor(13, "Jodie Whittaker");
            default : new Doctor(0, "John Hurt");
        }
        return null;
    }

    private static class Doctor {
        private int number;
        private String name;

        public Doctor(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
