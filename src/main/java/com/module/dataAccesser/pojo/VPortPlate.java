package com.module.dataAccesser.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name="v_port_plate")
public class VPortPlate implements Serializable {
    private static final long serialVersionUID =2L;

    @Id
    @Column(name="plate_id")
    private long plateId;
    @Column(name="plate_no")
    private String plateNo;
    @Column(name="trvalcrane_id")
    private long trvalcraneId;
    @Column(name="lane_no")
    private long lane_no;
    @Column(name="ctime")
    private Timestamp ctime;
    @Column(name="mtime")
    private Timestamp mtime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "plate_id")
    private List<VPortPlatePhoto> photos;
}
