package org.net.spring.boot.app.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.net.spring.boot.app.entity.User;
import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().userName("kaushal").password("kaushal8707").build()),
                Arguments.of(User.builder().userName("abc").password("ab123").build())
        );
    }
}
