package app;

import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenController;
import interface_adapter.HomeScreen.HomeScreenPresenter;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestController;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import interface_adapter.edit_profile.EditViewModel;
import use_case.HomeScreen.HomeScreenInputBoundary;
import use_case.HomeScreen.HomeScreenInteractor;
import use_case.HomeScreen.HomeScreenOutputBoundary;
import view.HomeScreenView;

public class HomeScreenUseCaseFactory {
    public static HomeScreenView create(ViewManagerModel viewManagerModel,
                                        CreateRequestViewModel createRequestViewModel,
                                        ViewRequestViewModel viewRequestViewModel,
                                        EditViewModel editViewModel,
                                        LockViewModel lockViewModel,
                                        HomeScreenViewModel homeScreenViewModel,
                                        ViewRequestController viewRequestController) {
        HomeScreenController homeScreenController = createHomeScreenUseCase(
                viewManagerModel,
                createRequestViewModel,
                viewRequestViewModel,
                editViewModel,
                lockViewModel,
                homeScreenViewModel);
        return new HomeScreenView(homeScreenController, homeScreenViewModel, viewRequestController);

    }

    private static HomeScreenController createHomeScreenUseCase(ViewManagerModel viewManagerModel,
                                                                CreateRequestViewModel createRequestViewModel,
                                                                ViewRequestViewModel viewRequestViewModel,
                                                                EditViewModel editProfileViewModel,
                                                                LockViewModel lockViewModel,
                                                                HomeScreenViewModel homeScreenViewModel) {

        HomeScreenOutputBoundary homeScreenOutputBoundary = new HomeScreenPresenter(
                createRequestViewModel,
                viewRequestViewModel,
                editProfileViewModel,
                viewManagerModel,
                lockViewModel,
                homeScreenViewModel);

        HomeScreenInputBoundary homeScreenInputBoundary = new HomeScreenInteractor(
                homeScreenOutputBoundary);

        return new HomeScreenController(homeScreenInputBoundary);
    }
}
