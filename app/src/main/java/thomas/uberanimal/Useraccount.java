package thomas.uberanimal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thoma on 22.12.2016.
 */

public class Useraccount implements Parcelable {

    private int age;
    private String name;

    public Useraccount(){
        super();
    }

    public Useraccount(Parcel parcel){
        this.name = parcel.readString();
        this.age = parcel.readInt();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(this.name);
        parcel.writeInt(this.age);
    }

    public static final Creator<Useraccount> CREATOR = new Creator<Useraccount>() {
        @Override
        public Useraccount createFromParcel(Parcel parcel) {
            return new Useraccount(parcel);
        }

        @Override
        public Useraccount[] newArray(int i) {
            return new Useraccount[i];
        }
    };

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

}