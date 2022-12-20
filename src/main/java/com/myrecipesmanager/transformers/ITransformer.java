package com.myrecipesmanager.transformers;

public interface ITransformer<T, U> {

    U transform(T inputObject, U outputObject);
}
