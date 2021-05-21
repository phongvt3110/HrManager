package castisvn.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import castisvn.entities.Report;

public class ReportSpecs {
	public static Specification<Report> filterByReporterProjectPosition(String reporter, ArrayList<String> project, String position){
		return new Specification<Report>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3355286511477402569L;

			@Override
			public Predicate toPredicate(Root<Report> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
				if(reporter != "" && reporter != null) {
					predicates.add(criteriaBuilder.equal(root.get("reporter"), reporter));
				}
				if(project != null) {
					predicates.add(root.get("project").in(project));
				}
				if(position != "" && position != null) {
					predicates.add(criteriaBuilder.equal(root.get("position"), position));
				}	
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};		
	}
	
	public static Specification<Report> hasLevelOfWork(String level, String desc){
		return new Specification<Report>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -2720823785111756065L;

			@Override
			public Predicate toPredicate(Root<Report> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
				if(level != null && level != "") {
					predicates.add(criteriaBuilder.equal(root.get("levelOfWork"), level));
				}
				if(desc != null) {					
					query.orderBy(criteriaBuilder.desc(root.get(desc)));
				}				
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}
}
