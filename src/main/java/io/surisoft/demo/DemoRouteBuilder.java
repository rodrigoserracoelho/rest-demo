package io.surisoft.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

public class DemoRouteBuilder extends RouteBuilder {
    private final int i;

    public DemoRouteBuilder(CamelContext camelContext, int i) {
        this.i = i;
    }

    @Override
    public void configure() throws Exception {

        String directRouteId = "demo-test-" + i;
        String restRouteId = "rd-demo-test-" + i;

        RouteDefinition routeDefinition = from("direct:" + directRouteId);
        buildException(routeDefinition);
        routeDefinition
                .loadBalance()
                .failover(1, false, true, false)
                .to("http://localhost:8081/test?bridgeEndpoint=true&throwExceptionOnFailure=false")
                .end()
                .routeId(directRouteId);

        rest().get("/demo" + i + "?matchOnUriPrefix=true").to("direct:" + directRouteId).routeId(restRouteId);

    }

    private void buildException(RouteDefinition routeDefinition) {
        routeDefinition
                .onException(Exception.class)
                .handled(true)
                .end();
    }
}
