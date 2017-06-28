package com.example.admin.comicsapp.services;

import com.example.admin.comicsapp.models.ComicsBaseJson;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static rx.Observable.empty;

/**
 * Created by Admin on 28/06/2017.
 */
public class ComicsRestServiceTest {

    @Mock
    ComicsRestApiService mockComicsRestApiService;
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    private ComicsRestService tested;

    @Before
    public void setUp() {
        tested = new ComicsRestService(mockComicsRestApiService);
    }

    @Test
    public void getGamesInfo() throws Exception {
        when(mockComicsRestApiService.getComics()).thenReturn(empty());
        TestSubscriber<ComicsBaseJson> subscriber = TestSubscriber.create();

        tested.getComicsInfo().subscribe(subscriber);

        verify(mockComicsRestApiService).getComics();
    }

}