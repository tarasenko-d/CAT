package com.example.cat.service.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FilterResolver {
    //TODO: додеалть
//
//    public static CriteriaQuery<Long> createCriteriaCount(CriteriaBuilder builder, GetEventsFilterRequest.EventFilter filter) {
//        var query = builder.createQuery(Long.class);
//        var root = query.from(Event.class);
//        var predicate = FilterResolver.createFilterPredicate(builder, root, filter);
//        return query
//                .select(builder.count(root))
//                .where(predicate);
//    }
//
//    public static CriteriaQuery<Event> createCriteriaResult(CriteriaBuilder builder, GetEventsFilterRequest.EventFilter filter) {
//        var query = builder.createQuery(Event.class);
//        var root = query.from(Event.class);
//        var predicate = FilterResolver.createFilterPredicate(builder, root, filter);
//        return query
//                .select(root)
//                .where(predicate)
//                .orderBy(builder.asc(root.get("dateTime")));
//    }
//
//    public static Predicate createFilterPredicate(CriteriaBuilder builder, Path<?> root, GetEventsFilterRequest.EventFilter filter) {
//        return builder.and(
//                addEqualCriteria(builder, root.get("title"), filter.getTitle()),
//                addBetweenDateTimeCriteria(builder, root.get("dateTime"), filter.getDateTimeFrom(), filter.getDateTimeTo()),
//                addBetweenLocationCriteria((builder, root.get("dateTime"), filter.getLatitude(), filter.getLongitude(), filter.getRadius()),
//                addEqualCriteria(builder, root.get("creatorName"), filter.getCreatorName()),
//                addEqualTagsClassCriteria(builder, root.get("tags"), filter.getTags())
//        );
//    }
//
//    public static <T> Predicate addEqualCriteria(CriteriaBuilder builder, Path<T> root, T value) {
//        if (nonNull(value)) {
//            return builder.equal(root, value);
//        }
//        return builder.conjunction();
//    }
//
//    public static <T> Predicate addBetweenLocationCriteria(CriteriaBuilder builder, Path<T> root, double latitude, double longitude, int radius) {
//        if (nonNull(latitude) && nonNull(longitude) && nonNull(longitude)) {
//            return builder.and(
//                    addBetweenPointCriteria(builder, root, latitude, radius, "latitude"),
//                    addBetweenPointCriteria(builder, root, longitude, radius, "longitude"));
//        }
//        return builder.conjunction();
//    }
//
//    public static <T> Predicate addBetweenPointCriteria(CriteriaBuilder builder, Path<T> root, double point, int radius, String fieldName) {
//        double rangePoint = searchRadius(point, radius);
//        return builder.between(root.get("latitude"), point - rangePoint, point + rangePoint);
//    }
//
//    public static <T> Predicate addBetweenDateTimeCriteria(CriteriaBuilder builder, Path<T> root, LocalDateTime dateFrom, LocalDateTime dateTo) {
//        if (nonNull(dateFrom)) {
//            if (nonNull(dateTo)) {
//                return builder.between(root.get("dateTime"), dateFrom, dateTo);
//            }
//            return builder.greaterThan(root.get("dateTime"), dateFrom);
//        }
//        return builder.conjunction();
//    }
//
//    public static Predicate addEqualTagsClassCriteria(CriteriaBuilder builder, Path<List<Tag>> root, List<String> tagsNames) {
//        if (nonNull(tagsNames)) {
//            List<Tag> tags = root.
//            for (Tag tag : root) {
//                builder.and(ContainsCriteria(builder, root, tag, "tags"));
//            }
//        }
//        return builder.conjunction();
//    }
//
//    public static <T> Predicate ContainsCriteria(CriteriaBuilder builder, Path<List<T>> root, T value, String fieldName) {
//        if (nonNull(value)) {
//            return builder.isMember(value, root.get(fieldName));
//        }
//        return builder.conjunction();
//    }
//
//    public static double searchRadius(double deg, int radius) {
//        double latitudeDelta = Math.PI / 180 * 6371210 * Math.cos(deg * Math.PI / 180);
//        return radius / latitudeDelta;
//    }
}
