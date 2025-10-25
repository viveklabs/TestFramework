package Interview;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;


public class AuthFilter implements Filter {


    @Override
    public Response filter(FilterableRequestSpecification reqSpec,
                           FilterableResponseSpecification respSpec,
                           FilterContext filterContext) {

        String token = ThreadLocalManager.getThreadVariable();

        if (token != null) {
            reqSpec.header("Autorization","Bearer" + token);
        }

        return filterContext.next(reqSpec,respSpec);
    }

}
