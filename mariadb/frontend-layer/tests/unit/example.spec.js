import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import WelcomeComponent from '@/components/WelcomeComponent.vue'

describe('WelcomeComponent.vue', () => {
  it('renders props.msg when passed', () => {
    const msg = 'new message'
    const wrapper = shallowMount(WelcomeComponent, {
      propsData: { msg }
    })
    expect(wrapper.text()).to.include(msg)
  })
})
