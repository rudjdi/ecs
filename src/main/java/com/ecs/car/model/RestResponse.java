package com.ecs.car.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestResponse {

    @Setter
    @Getter
    public class Self{
        public String href;
    }

    @Setter
    @Getter
    public class Links{
        public Self self;
    }
    public Links _links;
}
