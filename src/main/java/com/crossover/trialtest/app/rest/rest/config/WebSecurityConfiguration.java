package com.crossover.trialtest.app.rest.rest.config;

import com.crossover.trialtest.domain.participant.Participant;
import com.crossover.trialtest.domain.participant.ParticipantService;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    ParticipantService service;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<Participant> result = service.getByUsername(username);
                if (result.isPresent()) {
                    Participant p = result.get();
                    return new User(p.getUserName(), p.getPassword(), AuthorityUtils.createAuthorityList("USER", "write"));
                }
                throw new UsernameNotFoundException("could not find the user '" + username + "'");
            }
        };
    }
}

//@Configuration
//class WebMvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        List<HttpMessageConverter<?>> baseConverters = new ArrayList<>();
//        super.configureMessageConverters(baseConverters);
//
//        Iterable<HttpMessageConverter<?>> filtered = Iterables.filter(baseConverters, new Predicate<HttpMessageConverter<?>>() {
//            public boolean apply(HttpMessageConverter<?> c) {
//                return !(c instanceof Jaxb2RootElementHttpMessageConverter);
//            }
//        });
//        converters.addAll(Lists.newArrayList(filtered));
//    }
//}