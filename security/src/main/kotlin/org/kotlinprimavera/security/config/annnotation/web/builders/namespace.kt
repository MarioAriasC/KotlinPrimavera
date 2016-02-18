/*
 * Copyright 2015 Mario Arias
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kotlinprimavera.security.config.annnotation.web.builders

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.*
import org.springframework.security.config.annotation.web.configurers.openid.OpenIDLoginConfigurer

fun HttpSecurity.formLogin(body: FormLoginConfigurer<HttpSecurity>.() -> FormLoginConfigurer<HttpSecurity>): HttpSecurity {
    return formLogin().body().and()
}

fun HttpSecurity.exceptionHandling(body: ExceptionHandlingConfigurer<HttpSecurity>.() -> ExceptionHandlingConfigurer<HttpSecurity>): HttpSecurity {
    return exceptionHandling().body().and()
}

fun HttpSecurity.authorizeRequests(body: ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry.() -> ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry): HttpSecurity {
    return authorizeRequests().body().and()
}

fun HttpSecurity.logout(body: LogoutConfigurer<HttpSecurity>.() -> LogoutConfigurer<HttpSecurity>): HttpSecurity {
    return logout().body().and()
}

fun HttpSecurity.openidLogin(body: OpenIDLoginConfigurer<HttpSecurity>.() -> OpenIDLoginConfigurer<HttpSecurity>): HttpSecurity {
    return openidLogin().body().and()
}

fun HttpSecurity.headers(body: HeadersConfigurer<HttpSecurity>.() -> HeadersConfigurer<HttpSecurity>): HttpSecurity {
    return headers().body().and()
}

fun HttpSecurity.sessionManagement(body: SessionManagementConfigurer<HttpSecurity>.() -> SessionManagementConfigurer<HttpSecurity>): HttpSecurity {
    return sessionManagement().body().and()
}

fun HttpSecurity.portMapper(body: PortMapperConfigurer<HttpSecurity>.() -> PortMapperConfigurer<HttpSecurity>): HttpSecurity {
    return portMapper().body().and()
}

fun HttpSecurity.jee(body: JeeConfigurer<HttpSecurity>.() -> JeeConfigurer<HttpSecurity>): HttpSecurity {
    return jee().body().and()
}

fun HttpSecurity.x509(body: X509Configurer<HttpSecurity>.() -> X509Configurer<HttpSecurity>): HttpSecurity {
    return x509().body().and()
}

fun HttpSecurity.rememberMe(body: RememberMeConfigurer<HttpSecurity>.() -> RememberMeConfigurer<HttpSecurity>): HttpSecurity {
    return rememberMe().body().and()
}

fun HttpSecurity.requestCache(body: RequestCacheConfigurer<HttpSecurity>.() -> RequestCacheConfigurer<HttpSecurity>): HttpSecurity {
    return requestCache().body().and()
}

fun HttpSecurity.securityContext(body: SecurityContextConfigurer<HttpSecurity>.() -> SecurityContextConfigurer<HttpSecurity>): HttpSecurity {
    return securityContext().body().and()
}

fun HttpSecurity.servletApi(body: ServletApiConfigurer<HttpSecurity>.() -> ServletApiConfigurer<HttpSecurity>): HttpSecurity {
    return servletApi().body().and()
}

fun HttpSecurity.csrf(body: CsrfConfigurer<HttpSecurity>.() -> CsrfConfigurer<HttpSecurity>): HttpSecurity {
    return csrf().body().and()
}

fun HttpSecurity.anonymous(body: AnonymousConfigurer<HttpSecurity>.() -> AnonymousConfigurer<HttpSecurity>): HttpSecurity {
    return anonymous().body().and()
}

fun HttpSecurity.requiresChannel(body: ChannelSecurityConfigurer<HttpSecurity>.ChannelRequestMatcherRegistry.() -> ChannelSecurityConfigurer<HttpSecurity>.ChannelRequestMatcherRegistry): HttpSecurity {
    return requiresChannel().body().and()
}

fun HttpSecurity.httpBasic(body: HttpBasicConfigurer<HttpSecurity>.() -> HttpBasicConfigurer<HttpSecurity>): HttpSecurity {
    return httpBasic().body().and()
}













