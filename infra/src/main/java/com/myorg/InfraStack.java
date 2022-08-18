package com.myorg;

import software.amazon.awscdk.Duration;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class InfraStack extends Stack {
    public InfraStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public InfraStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        //create lambda function below
        Function.Builder.create(this, "hello-world-lambda")
                .runtime(Runtime.JAVA_11)
                .handler("com.wadhara.HelloWorldLambda")
                .memorySize(256)
                .timeout(Duration.seconds(120))
                .functionName("HelloWorldLambda")
                .code(Code.fromAsset("../assets/function.jar"))
                .build();
    }
}
