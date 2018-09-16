package com.example.tracerboxtwo;

import com.uber.jaeger.Tracer;
import com.uber.jaeger.metrics.Metrics;
import com.uber.jaeger.metrics.NullStatsReporter;
import com.uber.jaeger.metrics.StatsFactoryImpl;
import com.uber.jaeger.propagation.b3.B3TextMapCodec;
import com.uber.jaeger.reporters.RemoteReporter;
import com.uber.jaeger.samplers.ConstSampler;
import com.uber.jaeger.senders.HttpSender;
import io.opentracing.propagation.Format;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TracerBoxTwoApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        Tracer.Builder builder = new Tracer.Builder("tracer-box-two",
                new RemoteReporter(new HttpSender("http://jaeger-collector.istio-system:14268/api/traces"), 10,
                        65000, new Metrics(new StatsFactoryImpl(new NullStatsReporter()))),
                new ConstSampler(true))
                .registerInjector(Format.Builtin.HTTP_HEADERS, new B3TextMapCodec())
                .registerExtractor(Format.Builtin.HTTP_HEADERS, new B3TextMapCodec());
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(TracerBoxTwoApplication.class, args);
    }
}
