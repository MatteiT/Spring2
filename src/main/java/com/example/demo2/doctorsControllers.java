package com.example.demo2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DoctorController {

    @GetMapping("/doctor/{incarnationNumber}")
    public ResponseEntity<?> getDoctorDetails(@PathVariable int incarnationNumber) {
        switch (incarnationNumber) {
            case 9 -> {
                return ResponseEntity.ok(new Doctor(9, "Christopher Eccleston"));
            }
            case 10 -> {
                return ResponseEntity.ok(new Doctor(10, "David Tennant"));
            }
            case 11 -> {
                return ResponseEntity.ok(new Doctor(11, "Matt Smith"));
            }
            case 12 -> {
                return ResponseEntity.ok(new Doctor(12, "Peter Capaldi"));
            }
            case 13 -> {
                return ResponseEntity.ok(new Doctor(13, "Jodie Whittaker"));
            }
            default -> {
                if (incarnationNumber < 1) {
                    return ResponseEntity.notFound().build();
                } else if (incarnationNumber <= 8) {
                    return ResponseEntity.status(HttpStatus.SEE_OTHER).build();
                } else {
                    return ResponseEntity.notFound().build();
                }
            }
        }
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