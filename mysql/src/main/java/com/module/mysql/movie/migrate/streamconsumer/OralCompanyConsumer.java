package com.module.mysql.movie.migrate.streamconsumer;

import com.module.mysql.movie.entity.Company;
import com.module.mysql.movie.entity.oral.OralCompany;
import com.module.mysql.movie.migrate.persistQueue.PersistentMovieQueue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Consumer;

public class OralCompanyConsumer implements Consumer<OralCompany> {
    @Autowired
    PersistentMovieQueue movieQueue;
    @Getter @Setter
    private List<Company> companies;

    @Override
    public void accept(OralCompany oralCompany) {
        Company company = new Company(oralCompany);
        companies.add(company);
        movieQueue.offerCompanyInTime(company);
    }
}
