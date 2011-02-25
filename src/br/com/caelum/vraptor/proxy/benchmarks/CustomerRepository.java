package br.com.caelum.vraptor.proxy.benchmarks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class CustomerRepository {

    private final Map<Long, Customer> customers = new HashMap<Long, Customer>();

    @PostConstruct
    public void create() {
        for (int i = 0; i < 100; i++) {
            Long id = 1L + i;
            customers.put(id, new Customer(id, UUID.randomUUID().toString()));
        }
    }

    public List<Customer> findAll() {
        return new ArrayList<Customer>(customers.values());
    }

    public Customer find(Long id) {
        return customers.get(id);
    }
}
