package com.module.mysql.movie.migrate.streamconsumer;

import com.module.mysql.movie.entity.*;
import com.module.mysql.movie.entity.oral.OralCrew;
import com.module.mysql.movie.migrate.persistQueue.PersistentCrewQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class OralCrewConsumer implements Consumer<OralCrew> {
    @Autowired
    PersistentCrewQueue persistQueue;

    @Override
    public void accept(OralCrew oralCrew) {
        persistQueue.offerCrewInTime(new Crew(oralCrew));
        persistQueue.offerDeptJobInTime(new DeptJob(oralCrew.getDepartment(), oralCrew.getJob()));
        persistQueue.offerCreditInTime(new Credit(oralCrew.getCredit_id()));
    }
}
