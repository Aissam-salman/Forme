package com.forme.app.dto;

import com.forme.app.model.Path;
import jakarta.annotation.Nullable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CenterDto {
    private Long id;
    private String name;
    private String address;
    private String phone_number;
//    private List<Path> paths;
}
