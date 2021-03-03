package com.module.mysql.movie.migrate.persistQueue;

import com.module.mysql.movie.entity.Credit;
import com.module.mysql.movie.entity.Crew;
import com.module.mysql.movie.entity.DeptJob;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * [{"credit_id": "52fe48009251416c750aca23", "department": "Editing", "gender": 0, "id": 1721, "job": "Editor", "name": "Stephen E. Rivkin"}]
 */
@Getter
@Component
public class PersistentCrewQueue {
    int capacity = 5000;
    Logger logger = LoggerFactory.getLogger(PersistentCrewQueue.class);
    private BlockingQueue<Credit> credits = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<DeptJob> deptJobs = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Crew> crews = new ArrayBlockingQueue<>(capacity);


    public void offerCreditInTime(Credit credit){
        try{
            credits.offer(credit, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for credit: " + credit + "Exception: " + e.getMessage());
        }
    }

    public void offerDeptJobInTime(DeptJob deptJob){
        try{
            deptJobs.offer(deptJob, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for deptJob: " + deptJob + "Exception: " + e.getMessage());
        }
    }

    public void offerCrewInTime(Crew crew){
        try{
            crews.offer(crew, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for crew: " + crew + "Exception: " + e.getMessage());
        }
    }
}
