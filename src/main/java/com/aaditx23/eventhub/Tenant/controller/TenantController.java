package com.aaditx23.eventhub.Tenant.controller;

import com.aaditx23.eventhub.Tenant.model.SubscriptionType;
import com.aaditx23.eventhub.Tenant.model.Tenant;
import com.aaditx23.eventhub.Tenant.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/tenant")
public class TenantController {

    @Autowired
    TenantRepository tr;

    @PostMapping
    public Tenant addTenant(
            @RequestBody Tenant tenant
    ){
        return tr.save(tenant);
    }

    @PostMapping("/batch")
    public List<Tenant> addMultipleTenant(
            @RequestBody List<Tenant> tenants
    ){
        return tr.saveAll(tenants);
    }

    @GetMapping
    public List<Tenant> get(){
        return tr.findAll();
    }

    @GetMapping("/{id}")
    public Tenant getById(
            @PathVariable int id
    ){
        return tr.getTenantById(id);
    }

    @PatchMapping("/{id}/updateTenantName")
    public Tenant updateTenantName(
            @PathVariable int id,
            @RequestParam Map<String, Objects> updates
    ){
        Tenant tenant = tr.getTenantById(id);

        // TODO -> Validation
        if (updates.containsKey("name")) tenant.setName(updates.get("name").toString());
        if (updates.containsKey("subscription_type")) tenant.setSubscription_type(SubscriptionType.valueOf(updates.get("subscription_type").toString()));
        if (updates.containsKey("is_active")) tenant.set_active(Boolean.parseBoolean(updates.get("is_active").toString()));

        return tr.save(tenant);

    }


    @DeleteMapping
    public Tenant deleteTenant(
            @RequestParam int id
    ){
        Tenant tenant = tr.getTenantById(id);
        tr.delete(tenant);
        return tenant;
    }

}
