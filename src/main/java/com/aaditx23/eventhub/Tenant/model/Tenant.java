package com.aaditx23.eventhub.Tenant.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String slug;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new Date();
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscription_type = SubscriptionType.FREE;
    private boolean is_active;
}

