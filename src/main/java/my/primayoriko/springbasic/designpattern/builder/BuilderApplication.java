package my.primayoriko.springbasic.designpattern.builder;

import lombok.*;

import java.util.Date;
import java.util.List;

public class BuilderApplication {

    @Builder
    @Data
    @AllArgsConstructor
    public static class Mahasiswa {
        private String name;
        private Integer id;
        private Date tanggalLahir;

        @Singular("hobi")
        private List<String> hobi;
    }

    public static void main(String[] args) {

        Mahasiswa mahasiswa = Mahasiswa.builder()
                .id(123)
                .name("uhuy")
                .tanggalLahir(new Date())
                .hobi("makan")
                .hobi("tidur")
                .hobi("rebahan")
                .build();

        System.out.println(mahasiswa);
    }

}
