package com.betaseries.betaseries.dagger;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.lang.reflect.Field;

/**
 * Created by florentchampigny on 14/08/15.
 */
public class GsonStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipClass( Class<?> type ) {

        return false;
    }

    /**
     * Indicates that fields used by Sugar ORM should be skipped.
     */
    @Override
    public boolean shouldSkipField( FieldAttributes fieldAttributes ) {

        if ( "application".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "context".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "database".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "id".equals( fieldAttributes.getName() ) && fieldAttributes.getAnnotation(SerializedName.class) == null ) {
            return true;
        }
        if ( "tableName".equals( fieldAttributes.getName() ) ) {
            return true;
        }

        return false;
    }

}
