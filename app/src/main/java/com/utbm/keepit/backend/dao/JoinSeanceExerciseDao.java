package com.utbm.keepit.backend.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.utbm.keepit.backend.entity.JoinSeanceExercise;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOIN_SEANCE_EXERCISE".
*/
public class JoinSeanceExerciseDao extends AbstractDao<JoinSeanceExercise, Void> {

    public static final String TABLENAME = "JOIN_SEANCE_EXERCISE";

    /**
     * Properties of entity JoinSeanceExercise.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property SeanceId = new Property(0, Long.class, "seanceId", false, "SEANCE_ID");
        public final static Property ExerciseId = new Property(1, Long.class, "exerciseId", false, "EXERCISE_ID");
    }


    public JoinSeanceExerciseDao(DaoConfig config) {
        super(config);
    }
    
    public JoinSeanceExerciseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOIN_SEANCE_EXERCISE\" (" + //
                "\"SEANCE_ID\" INTEGER," + // 0: seanceId
                "\"EXERCISE_ID\" INTEGER);"); // 1: exerciseId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOIN_SEANCE_EXERCISE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, JoinSeanceExercise entity) {
        stmt.clearBindings();
 
        Long seanceId = entity.getSeanceId();
        if (seanceId != null) {
            stmt.bindLong(1, seanceId);
        }
 
        Long exerciseId = entity.getExerciseId();
        if (exerciseId != null) {
            stmt.bindLong(2, exerciseId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, JoinSeanceExercise entity) {
        stmt.clearBindings();
 
        Long seanceId = entity.getSeanceId();
        if (seanceId != null) {
            stmt.bindLong(1, seanceId);
        }
 
        Long exerciseId = entity.getExerciseId();
        if (exerciseId != null) {
            stmt.bindLong(2, exerciseId);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public JoinSeanceExercise readEntity(Cursor cursor, int offset) {
        JoinSeanceExercise entity = new JoinSeanceExercise( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // seanceId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) // exerciseId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, JoinSeanceExercise entity, int offset) {
        entity.setSeanceId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setExerciseId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(JoinSeanceExercise entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(JoinSeanceExercise entity) {
        return null;
    }

    @Override
    public boolean hasKey(JoinSeanceExercise entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}