package com.example.admin.comicsapp.comics;

import com.example.admin.comicsapp.models.ComicsBaseJson;
import com.example.admin.comicsapp.services.ComicsRestService;

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
public class ComicsViewModelTest {
    @Mock
    ComicsRestService mockComicsRestService;
    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    private ComicsViewModel tested;

    @Before
    public void setUp() {
        tested = new ComicsViewModel(mockComicsRestService);
    }

    @Test
    public void shouldFetchGamesWhenLoadGamesRequested() {
        when(mockComicsRestService.getComicsInfo()).thenReturn(empty());
        TestSubscriber<ComicsBaseJson> subscriber = TestSubscriber.create();

        tested.onFetchComics().subscribe(subscriber);

        verify(mockComicsRestService).getComicsInfo();
        //subscriber.assertValueCount(8);
        //subscriber.assertNoErrors();

    }

}