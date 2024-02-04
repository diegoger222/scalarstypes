package feature.infrastructure.repository.specification;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;

public class ActivitySpecifications {

    public static Query buildQuery(Criteria... criteriaList) {
        return new Query().addCriteria(new Criteria().andOperator(criteriaList));
    }

    public static Criteria priceGreaterThan(double price) {
        return Criteria.where("price").gte(price);
    }

    public static Criteria nameEquals(String name) {
        return Criteria.where("name").is(name);
    }

    public static Criteria nameOrCategory(String nameFilter){
        return  new Criteria().orOperator(
                Criteria.where("name").regex(nameFilter, "i"),
                Criteria.where("category").regex(nameFilter, "i"));
    }

    public static Criteria expired() {
        return Criteria.where("expirationDate").lt(LocalDate.now());
    }

        public Query patata(){
        return buildQuery(
                expired(),
                nameOrCategory("patata")
        );
    }
}