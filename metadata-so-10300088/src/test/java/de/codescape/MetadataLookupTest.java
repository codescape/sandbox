package de.codescape;

import org.junit.Test;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MetadataLookupTest {

    @Test
    public void shouldReturnMethodArrayWithPlainJava() throws Exception {
        Method method = SomeAnnotatedController.class.getDeclaredMethod("someMethod");
        RequestMapping annotation = method.getAnnotation(RequestMapping.class);
        assertEquals(1, annotation.method().length);
        assertEquals(RequestMethod.GET, annotation.method()[0]);
    }

    @Test
    public void shouldReturnMethodArrayWithSpringMetadataReader() throws Exception {
        MetadataReader metadataReader = new CachingMetadataReaderFactory().getMetadataReader(SomeAnnotatedController.class.getName());
        Set<MethodMetadata> annotatedMethods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(RequestMapping.class.getName());
        assertEquals(1, annotatedMethods.size());
        MethodMetadata methodMetadata = annotatedMethods.iterator().next();
        assertEquals("someMethod", methodMetadata.getMethodName());
        Map<String, Object> annotationAttributes = methodMetadata.getAnnotationAttributes(RequestMapping.class.getName());
        assertTrue(annotationAttributes.containsKey("method"));
        RequestMethod[] methodAttribute = (RequestMethod[]) annotationAttributes.get("method");
        assertEquals(1, methodAttribute.length);
    }

}
