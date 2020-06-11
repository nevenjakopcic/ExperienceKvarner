package hr.tvz.android.experiencekvarner.model;

import lombok.Data;

@Data
public class ActivityModel {

    private final Long id;
    private final String name;
    private final String description;
    private final Float score;
}
