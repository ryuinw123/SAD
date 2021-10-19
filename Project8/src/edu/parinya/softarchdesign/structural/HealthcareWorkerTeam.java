package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{

    private Set<HealthcareServiceable> members = new LinkedHashSet();

    public void addMember(HealthcareServiceable healthcareServiceable){
        members.add(healthcareServiceable);
    }
    public void removeMember(HealthcareServiceable healthcareServiceable){
        members.remove(healthcareServiceable);
    }

    @Override
    public void service() {
        for (HealthcareServiceable heal : members){
            heal.service();
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (HealthcareServiceable healthcareServiceable : members){
            price += healthcareServiceable.getPrice();
        }
        return price;
    }
}
