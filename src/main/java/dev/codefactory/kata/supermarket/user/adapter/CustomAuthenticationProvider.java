package dev.codefactory.kata.supermarket.user.adapter;

import dev.codefactory.kata.supermarket.user.core.LoginUseCase;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@RequiredArgsConstructor
@Singleton
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final LoginUseCase loginUseCase;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flux.create(emitter -> {
            if (authenticationRequest.getIdentity().equals("sherlock") &&
                    authenticationRequest.getSecret().equals("password")) {
                emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity()));
                emitter.complete();
            } else {
                emitter.error(AuthenticationResponse.exception());
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }
}
