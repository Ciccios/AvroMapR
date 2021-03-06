/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.nice.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"com.nice.model\",\"fields\":[{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"password\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence username;
  @Deprecated public java.lang.CharSequence password;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public User() {}

  /**
   * All-args constructor.
   */
  public User(java.lang.CharSequence username, java.lang.CharSequence password) {
    this.username = username;
    this.password = password;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return username;
    case 1: return password;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: username = (java.lang.CharSequence)value$; break;
    case 1: password = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'username' field.
   */
  public java.lang.CharSequence getUsername() {
    return username;
  }

  /**
   * Sets the value of the 'username' field.
   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /**
   * Gets the value of the 'password' field.
   */
  public java.lang.CharSequence getPassword() {
    return password;
  }

  /**
   * Sets the value of the 'password' field.
   * @param value the value to set.
   */
  public void setPassword(java.lang.CharSequence value) {
    this.password = value;
  }

  /** Creates a new User RecordBuilder */
  public static com.nice.model.User.Builder newBuilder() {
    return new com.nice.model.User.Builder();
  }
  
  /** Creates a new User RecordBuilder by copying an existing Builder */
  public static com.nice.model.User.Builder newBuilder(com.nice.model.User.Builder other) {
    return new com.nice.model.User.Builder(other);
  }
  
  /** Creates a new User RecordBuilder by copying an existing User instance */
  public static com.nice.model.User.Builder newBuilder(com.nice.model.User other) {
    return new com.nice.model.User.Builder(other);
  }
  
  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private java.lang.CharSequence username;
    private java.lang.CharSequence password;

    /** Creates a new Builder */
    private Builder() {
      super(com.nice.model.User.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.nice.model.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.username)) {
        this.username = data().deepCopy(fields()[0].schema(), other.username);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.password)) {
        this.password = data().deepCopy(fields()[1].schema(), other.password);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing User instance */
    private Builder(com.nice.model.User other) {
            super(com.nice.model.User.SCHEMA$);
      if (isValidValue(fields()[0], other.username)) {
        this.username = data().deepCopy(fields()[0].schema(), other.username);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.password)) {
        this.password = data().deepCopy(fields()[1].schema(), other.password);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'username' field */
    public java.lang.CharSequence getUsername() {
      return username;
    }
    
    /** Sets the value of the 'username' field */
    public com.nice.model.User.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.username = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'username' field has been set */
    public boolean hasUsername() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'username' field */
    public com.nice.model.User.Builder clearUsername() {
      username = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'password' field */
    public java.lang.CharSequence getPassword() {
      return password;
    }
    
    /** Sets the value of the 'password' field */
    public com.nice.model.User.Builder setPassword(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.password = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'password' field has been set */
    public boolean hasPassword() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'password' field */
    public com.nice.model.User.Builder clearPassword() {
      password = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public User build() {
      try {
        User record = new User();
        record.username = fieldSetFlags()[0] ? this.username : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.password = fieldSetFlags()[1] ? this.password : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
