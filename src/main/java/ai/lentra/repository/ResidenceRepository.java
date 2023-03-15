package ai.lentra.repository;

import ai.lentra.modal.residence.ResidenceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ResidenceRepository extends JpaRepository<ResidenceDetails,Long> {
    @Query(value = "SELECT r.id, r.residence_category, r.ownership_type,r.living_with,r.residence_type,r.no_of_storey," +
            "r.classification,r.house_condition,r.property_age,r.property_interior,r.name_plate_visible,r.appliances," +
            "r.appliances_total_value,r.commute_options,r.neighbourhood_type,r.residency,r.country,r.years_of_stay," +
            "r.months_of_stay,r.distance_from_address_to_actual_loaction, r.negative_location,r.monthly_amortization," +
            "r.rent_per_month,r.landline_num,r.address_line_1,r.address_line_2,r.address_line_3,r.address_line_4," +
            "r.city,r.state,r.pincode,r.country_code,r.lattitue,r.longitude,r.mail_delivery_status,r.address_proof_id," +
            "r.owned_by,r.mortagagor_name,r.rented_from,r.residence_landmark,r.pers_met,r.community_dominated," +
            "r.property_make_type,r.score,r.applicant_id from vms_db.residence_fi r WHERE r.applicant_id =?1",nativeQuery = true)
    Optional<ResidenceDetails> findByAppId(Long residenceId);
}
