package com.example.mvvmpattern.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmpattern.model.User;
import com.example.mvvmpattern.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

    UserRepository userRepository;

    //private MutableLiveData<String> resultLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
    }


    public LiveData<User[]> getAllUserData(){

        return userRepository.getUserData();
    }





    /**
     * Addition Function
     * @param value1
     * @param value2
     * @return
     */
    /*public MutableLiveData<String> additionFunction(String value1, String value2){

        int number1 = Integer.parseInt(value1);
        int number2 = Integer.parseInt(value2);

        int result = number1 + number2;


        if (resultLiveData == null){
            resultLiveData = new MutableLiveData<>();

        }

        resultLiveData.setValue(String.valueOf(result));

        return resultLiveData;
    }*/
}
