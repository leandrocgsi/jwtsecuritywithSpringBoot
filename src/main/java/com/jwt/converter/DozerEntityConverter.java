package com.jwt.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerEntityConverter {

	private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origin , Class<D> destination){
		return mapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObject(List<O> origin , Class<D> destination){
		List<D> dastinationObjects = new ArrayList<D>();
		
		for (Object o : origin) {
			dastinationObjects.add(mapper.map(o, destination));
		}
		return dastinationObjects;
	}
}
