package br.com.caelum.vraptor.proxy.benchmarks;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class CustomerController {

    private final Result result;
    private final CustomerRepository repository;

    public CustomerController(Result result, CustomerRepository customerRepository) {
        this.result = result;
        this.repository = customerRepository;
    }

    @Get("/customers")
    public void list() {
        result.use(Results.xml()).from(repository.findAll()).serialize();
    }

    @Get("/customers/{id}")
    public void show(Long id) {
        result.forwardTo(this).list();
    }
}
