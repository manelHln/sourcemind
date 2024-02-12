import {expect, it} from 'vitest'
import { calcAge } from './myFunc'

it("should return adult", ()=>{
    let result = calcAge(2002)

    expect(result).toBe("adult")
})

it("should return adult", ()=>{
    let result = calcAge(2020)

    expect(result).toBe("kid")
})

it("should return false", ()=>{
    let result = calcAge()

    expect(result).toBe(false)
})