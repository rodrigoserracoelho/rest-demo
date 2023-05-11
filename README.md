In the RestDemo class you will find the code that create the DemoRouteBuilder.

````
//To replicate the error, put inline routes to true
camelContext.getRestConfiguration().setInlineRoutes(true);

//If you create just 1 route it works.
for(int i=0; i<2; i++) {
   camelContext.addRoutes(new DemoRouteBuilder(camelContext, i));
}
````

- If i=1, one single route is created without errors
- If i>1, if will fail with the error reported in the chat.
```
java.lang.ClassCastException: class org.apache.camel.model.OnExceptionDefinition cannot be cast to class org.apache.camel.model.ToDefinition (org.apache.camel.model.OnExceptionDefinition and org.apache.camel.model.ToDefinition are in unnamed module of loader 'app')
	at org.apache.camel.impl.DefaultModel.addRouteDefinitions(DefaultModel.java:224) ~[camel-core-engine-3.20.4.jar:3.20.4]
```
- If you put the inline routes to false, then if will always create all the routes.