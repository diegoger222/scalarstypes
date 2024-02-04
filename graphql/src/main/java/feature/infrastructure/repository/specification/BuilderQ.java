package feature.infrastructure.repository.specification;

//import static feature.infrastructure.repository.specification.ActivitySpecifications;
import  org.springframework.data.mongodb.core.query.Query;

import static feature.infrastructure.repository.specification.ActivitySpecifications.*;

public class BuilderQ {

    public Query patata() {
        return buildQuery(
                nameOrCategory("patata"),
                priceGreaterThan(29),
                or(nameEquals("hi"),nameEquals("nope"))
        );
    }
}
