package com.example.mgkan.hackathon_lost_pets;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.List;

/**
 * Created by erikrudie on 10/17/16.
 */

public class ButtonAnimationHandler {

  private List<Button> buttons;
  private Animation animation;
  private Intent intent;
  private ButtonAnimationHandler parent;
  private Context context;

  private static final int delay = 25;

  public ButtonAnimationHandler(List<Button> buttons, Context context) {
    this.buttons = buttons;
    this.animation = animation;
    this.parent = this;
    this.context = context;
  }

  public void execute() {

    if (intent != null) {
      this.animation.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
          context.startActivity(intent);
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
      });
    }

    buttons.get(0).startAnimation(animation);
    buttons.remove(0);

    if (buttons.size() > 0) {
      new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          parent.execute();
        }
      }, delay);
    }

  }

  public void setIntent(Intent intent) {
    this.intent = intent;
  }

  public void setAnimation(Animation animation) {
    this.animation = animation;
  }

  public boolean hasButtons() {
    return buttons.size() > 0;
  }

}
